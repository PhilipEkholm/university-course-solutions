CC:=avrasm2

TARGET:=app/main.asm

MMCU:=atmega32u4

#atmega328p

MMCU_SHORT:=m32u4
#m328p

COM_PORT:=/dev/tty.usbmodem1411

make: $(TARGET)
	wine avrasm2 -f I -o program.hex app/main.asm
	@#-p will ignore error if folder already exists
	@mkdir -p out
	@mv *.hex out

	@echo 'Successfully built project'

clean:
	@echo 'Removing out folder'
	@#@ for supressing echoing message in terminal
	@#-rf to remove folder even if files already exists inside
	@rm -rf out/

.PHONY: clean

send:
	avrdude -c avr109 -p $(MMCU_SHORT) -P $(COM_PORT) -b 57600 -U flash:w:out/program.hex
#-c arduino, -b 115200
.PHONY: send