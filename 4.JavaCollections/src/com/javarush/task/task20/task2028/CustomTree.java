package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
  
  private Entry<String> root;
  private Map<String, Entry<String>> tree;
  
  public CustomTree() {
    root = new Entry<>("root");
    tree = new LinkedHashMap<>();
    tree.put("0", root);
  }
  

  @Override
  public boolean add(String element) {
    return null == tree.put(element, new Entry<>(element));
  }

  @Override
  public int size() {
    return tree.size() - 1;
  }

  public String getParent(String s) {
    try {
      return tree.get(s).getElementName();//todo
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
    public Entry(String elementName) {
      this.elementName = elementName;
      availableToAddLeftChildren = true;
      availableToAddRightChildren = true;
    }

    boolean availableToAddLeftChildren, availableToAddRightChildren;

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
  }
}
