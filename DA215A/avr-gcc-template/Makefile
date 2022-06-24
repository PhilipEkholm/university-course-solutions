CC:=avr-gcc

CFLAGS+= \
	-std=c99 -g \
	-ffunction-sections \
	-fdata-sections \
	-fno-strict-aliasing \
	-Wunused-function \
	-Werror \
	-I. \
	-I./app \

TARGET:=app/main.c

MMCU:=atmega32u4
#atmega328p

MMCU_SHORT:=m32u4
#m328p

COM_PORT:=/dev/tty.usbmodem1411

make: $(TARGET)
	@$(CC) -g -Os -mmcu=$(MMCU) -c $(TARGET) $(CFLAGS)
	@#-p will ignore error if folder already exists
	@mkdir -p out
	@$(CC) -g -mmcu=$(MMCU) -o program.elf main.o $(CFLAGS)
	@avr-objcopy -j .text -j .data -O ihex program.elf program.hex
	@mv *.o out
	@mv *.elf out
	@mv *.hex out

	@echo 'Successfully built project'

send:
	avrdude -c avr109 -p $(MMCU_SHORT) -P $(COM_PORT) -b 57600 -U flash:w:out/program.hex
#-c arduino, -b 115200

.PHONY: send

clean:
	@echo 'Removing out folder'
	@#@ for supressing echoing message in terminal
	@#-rf to remove folder even if files already exists inside
	@rm -rf out/

.PHONY: clean







