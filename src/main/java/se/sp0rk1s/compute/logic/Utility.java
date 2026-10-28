package se.sp0rk1s.compute.logic;

public class Utility {
	/// @param bytes The amount of bytes we are measuring.
	/// @return
	/// A string combined with the prefix and unit.<br/>
	/// 1024 -> "1kB"
	public static String MetricPrefix(int bytes) {
		String[] units = {"B", "kB", "MB", "GB", "TB", "PB"};
		int unit = (int)(Math.log(bytes) / Math.log(1024));
		int newValue = bytes / (int)Math.pow(1024, unit);
		return String.format("%,d %s", newValue, units[unit]);
	}

	/// @param bytes The amount of bytes we are measuring.
	/// @return
	/// A string combined with the prefix and unit.<br/>
	/// 1024 -> "1kB"
	public static String VerboseMetricPrefix(int bytes) {
		String[] units = {"Bytes", "Kilobytes", "Megabytes", "Gigabytes", "Terrabytes", "Petabytes"};
		int unit = (int)(Math.log(bytes) / Math.log(1024));
		int newValue = bytes / (int)Math.pow(1024, unit);
		return String.format("%,d %s", newValue, units[unit]);
	}
}
