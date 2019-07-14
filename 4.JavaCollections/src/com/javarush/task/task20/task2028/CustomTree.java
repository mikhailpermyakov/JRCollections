package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

  Entry<String> root = new Entry<>("0");
  private Map<String, Entry<String>> tree = new LinkedHashMap<>();

  public CustomTree() {
//    tree.put("0", root);
  }


  @Override
  public boolean add(String element) {
    Entry<String> newEntry = new Entry<>(element);
    if (tree.size() == 0)
      tree.put("0", root);
    List<Entry<String>> nodes = new ArrayList<>();
    //collect all nodes that isAvailableToAddChildren() first
    tree.forEach((k, v) -> {
      if (tree.get(k).isAvailableToAddChildren()) {
        nodes.add(tree.get(k));
      }
    });
    String custodianName = nodes.get(nodes.size() - 1).getElementName();
    //now iterate through the nodes
    //to find the lowest (by value)
    for (Entry<String> entry : nodes) {
      if (Integer.valueOf(entry.getElementName()) < Integer.valueOf(custodianName))
        custodianName = entry.getElementName();
    }

    //set it as a parent
    Entry<String> aCustodian = tree.get(custodianName);//the found parent
    newEntry.setParent(aCustodian);
    if (null == aCustodian.getLeftChild()) {//first check if left child is null
      aCustodian.setLeftChild(newEntry);
    } else if (null == aCustodian.getRightChild()) {
      aCustodian.setRightChild(newEntry);//if not add new entry as a right child
    }
    tree.put(aCustodian.getElementName(), aCustodian);//update a parent
    return null == tree.put(element, newEntry);
  }

  @Override
  public int size() {
    return tree.size() - 1;
  }

  String getParent(String s) {
    try {
      return tree.get(s).getParent().getElementName();
    } catch (NullPointerException e) {
      return null;
    }
  }


  @Override
  public String get(int index) {
    throw new UnsupportedOperationException();
  }

  public String set(int index, String element) {
    throw new UnsupportedOperationException();
  }

  public void add(int index, String element) {
    throw new UnsupportedOperationException();
  }

  public String remove(int index) {
    throw new UnsupportedOperationException();
  }

  public List<String> subList(int fromIndex, int toIndex) {
    throw new UnsupportedOperationException();
  }

  protected void removeRange(int fromIndex, int toIndex) {
    throw new UnsupportedOperationException();
  }

  public boolean addAll(int index, Collection<? extends String> c) {
    throw new UnsupportedOperationException();
  }

  static class Entry<T> implements Serializable {

    String elementName;

    Entry<T> parent, leftChild, rightChild;

    boolean availableToAddLeftChildren, availableToAddRightChildren;

    public Entry(String elementName) {
      this.elementName = elementName;
      availableToAddLeftChildren = true;
      availableToAddRightChildren = true;
    }

    public Entry<T> getParent() {
      return parent;
    }

    public Entry<T> getLeftChild() {
      return leftChild;
    }

    public Entry<T> getRightChild() {
      return rightChild;
    }

    public boolean isAvailableToAddChildren() {
      return availableToAddLeftChildren || availableToAddRightChildren;
    }

    public String getElementName() {
      return elementName;
    }

    public void setParent(Entry<T> parent) {
      this.parent = parent;
    }

    public void setLeftChild(Entry<T> leftChild) {
      this.leftChild = leftChild;
      availableToAddLeftChildren = false;
    }

    public void setRightChild(Entry<T> rightChild) {
      this.rightChild = rightChild;
      availableToAddRightChildren = false;
    }
  }
}
