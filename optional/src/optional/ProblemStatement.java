package optional;

public class ProblemStatement {

	public static void main(String[] args) {
		var computer = new Computer();
		var usbDriver = computer.getUsbDriver();

		if (usbDriver != null) {
			var writeProtectSwitch = usbDriver.getWriteProtectSwitch();
			if (writeProtectSwitch != null) {
				// some code...
			}
		} else {

		}

	}

	private static class Computer {

		private UsbDriver usbDriver;

		public UsbDriver getUsbDriver() {
			return this.usbDriver;
		}
	}

	private static class UsbDriver {

		private WriteProtectSwitch writeProtectSwitch;

		public WriteProtectSwitch getWriteProtectSwitch() {
			return writeProtectSwitch;
		}
	}

	private static class WriteProtectSwitch {

	}
}
