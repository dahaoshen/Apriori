package com.liuhao.AprioriAll;

import java.util.ArrayList;
import java.util.Iterator;

public class Sequence implements Cloneable {
	private int support;
	private ArrayList<String> items;

	public int getSupport() {
		return support;
	}

	public void setSupport(int support) {
		this.support = support;
	}
	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}
	public void setItems(String s) {
		 
	}

	public Sequence(String[] data, int support) {
		this.support = support;
		items=new ArrayList<String>();
		for(String s:data){
			items.add(s);
		}
	}
	public Sequence(String s,int support){
		this.support=support;
		items=new ArrayList<String>();
		items.add(s);
	}

	public Sequence() {

	}

	public boolean isIncluded(Sequence seq) {
		int index = 0;
		Iterator it = this.items.iterator();
		for(int i=0;i<this.items.size();){
			if((index=seq.items.indexOf(this.items.get(i)))!=(seq.items.size()-1)){
				++index;
				++i;
			} else {
				return false;
			}
		}
		return true;
	}

	public Sequence join(Sequence seq) throws CloneNotSupportedException {
		Sequence temp = new Sequence();
		temp.items = (ArrayList<String>) this.items.clone();
		temp.items.addAll(temp.items.size(), seq.items);
		return temp;
	}

	public Sequence getPrefix() {
		Sequence temp = new Sequence();
		for (String s:this.items) {
			temp.items.add(s);
		}
		return temp;
	}

	public void print() {
		Iterator it = this.items.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
	public void countSupport(){
		this.support++;
	}
}
