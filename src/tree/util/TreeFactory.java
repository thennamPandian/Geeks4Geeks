package tree.util;

import java.util.ArrayList;
import java.util.List;

public class TreeFactory {

	public static Tree createNormalGenericTree() {
		List<List<Integer>> values = new ArrayList<List<Integer>>();

		List<Integer> list = new ArrayList<>();
		list.add(1);
		values.add(list);

		list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		values.add(list);

		values.add(null);

		list = new ArrayList<>();
		list.add(5);
		list.add(6);
		values.add(list);

		values.add(null);
		values.add(null);

		list = new ArrayList<>();
		list.add(7);
		values.add(list);

		return TreeUtil.createGenericNode(values);
	}

	public static Tree createSingleElementGenericTree() {
		List<List<Integer>> values = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		values.add(list);
		return TreeUtil.createGenericNode(values);
	}

	public static Tree createNoSiblingGenericTree() {

		List<List<Integer>> values = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		values.add(list);

		list = new ArrayList<>();
		list.add(2);
		values.add(list);

		list = new ArrayList<>();
		list.add(3);
		values.add(list);

		return TreeUtil.createGenericNode(values);
	}

	public static Tree createNoChildGenericTree() {

		List<List<Integer>> values = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		values.add(list);

		list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		values.add(list);

		
		return TreeUtil.createGenericNode(values);
	}

}
