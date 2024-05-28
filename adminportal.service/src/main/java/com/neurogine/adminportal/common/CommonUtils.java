package com.neurogine.adminportal.common;

import java.lang.reflect.Array;
import java.util.List;

public abstract class CommonUtils {
	public static <T> T[] getArrayFromList(Class<T> clazz, List<T> t) {
		T[] array = null;
		if (t != null && t.size() > 0) {
			array = (T[]) Array.newInstance(clazz, t.size());
			array = t.toArray(array);
		}
		return array;
	}

}
