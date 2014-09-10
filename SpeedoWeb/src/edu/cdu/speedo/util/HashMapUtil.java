package edu.cdu.speedo.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapUtil {

	public static void remove(HashMap map, String key) {
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			Object keyObject = entry.getKey();
			if (keyObject.toString().equals(key)) {
				map.remove(keyObject);
			}

		}
	}
}
