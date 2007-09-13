package earthnews.geocoding.internal;

import earthnews.geocoding.Location;

/**
 * A Locator returns a Location Object given a String.
 *
 */
public interface Locator
{
	/**
	 * Returns a Location for a String 
	 * @param pString text from which the location has to be determined.
	 * @return a Location.
	 */
	public Location locateString(String pString);
}
