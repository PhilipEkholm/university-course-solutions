package laboration6;

import javax.swing.JOptionPane;

public class Car {
	private String 	mBrand,
					mModel;
	private int mHp;
	
	public void setmBrand(String mBrand) {
		this.mBrand = mBrand;
	}
	
	public void setmModel(String mModel) {
		this.mModel = mModel;
	}
	
	public void setmHp(int mHp) {
		this.mHp = mHp;
	}
	
	public void info() {
		JOptionPane.showMessageDialog(null, "Märke: " + mBrand + "\nModell: " + mModel + "\nHorsepowers: " + mHp);
	}
}
