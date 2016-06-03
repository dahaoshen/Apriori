package com.liuhao.AprioriAll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class AprioriAll {
	private  String path;
	private  int minsupport;
	private  ArrayList<Sequence> seqList;
	private  ArrayList<Sequence> totalFrequencySeqs;
	//private Sequence seq;
	public AprioriAll(String path,int minsupport){
			this.path=path;
			this.minsupport=minsupport;
			readDataFile();
	}
	
   public ArrayList<Sequence> getSeqList() {
		return seqList;
	}

	public void setSeqList(ArrayList<Sequence> seqList) {
		this.seqList = seqList;
	}

public void readDataFile() {
	seqList=new ArrayList<Sequence>();
	File file = new File(path);
	try {
		BufferedReader in = new BufferedReader(new FileReader(file));
		String str;
		String[] tempArray;
		while ((str = in.readLine()) != null) {
			tempArray = str.split(" ");
			Sequence seq=new Sequence(tempArray,0);
			seqList.add(seq);
		}
		in.close();
	    } catch (IOException e) {
		e.getStackTrace();
	}
  }
   public void print(ArrayList<Sequence> seqList){
	   for(Sequence seq:seqList){
		   seq.print();
		   System.out.println();
	   }
   }
   
   public void calculateSupport(ArrayList<Sequence> seqDB,ArrayList<Sequence> seqs){
	   for(Sequence seq:seqs){
		   for(Sequence seqdb:seqDB){
			  if(seq.isIncluded(seqdb)){
				  seq.countSupport();
			  }
		   }
	   }
   }
   public void generateOne(){
	   ArrayList<Sequence> seqs=new ArrayList<Sequence>();
	   for(int i=1;i<=17;++i){
		   Sequence seq=new Sequence(Integer.toString(i),0);
		   seqs.add(seq);
	   	}
	   calculateSupport(seqList, seqs);
	   for(Sequence seq:seqs){
		   if(seq.getSupport()<minsupport){
			   seqs.remove(seq);
		   }
	   }
	   print(seqs);
   }
   
}