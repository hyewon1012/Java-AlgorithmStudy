package com.ssafy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

	private char[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		super();
		SIZE = size;
		nodes = new char[size+1];
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(char e) {
		if(isFull()) {
			System.out.println("��ȭ�����Դϴ�.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		
		if(isEmpty()) return;
		
		//Ž�� ���� ��ȣ�� ť�� ����
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		int current;
		while(!q.isEmpty()) {
			current = q.poll();
			System.out.println(nodes[current]);
			if(current*2 <= lastIndex) q.offer(current*2); // ���� �ڽ�
			if(current*2+1 <= lastIndex) q.offer(current*2+1); // ������ �ڽ�
		}
		
	}
	
	public void bfs2() {
		
		if(isEmpty()) return;
		
		//Ž�� ���� ��ȣ�� ť�� ����
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		int current, size, level = 0;
		while(!q.isEmpty()) {
			
			size = q.size();// �� level�� ����� ����
			System.out.print("level"+level+":");
			while(--size >= 0) {
				current = q.poll();
				System.out.print(nodes[current]);
				if(current*2 <= lastIndex) q.offer(current*2); // ���� �ڽ�
				if(current*2+1 <= lastIndex) q.offer(current*2+1); // ������ �ڽ�
			}
			System.out.println();
			++level;
		}
		
	}
	
	//���� ��ȸ
	public void dfs(int current) {
		if(current > lastIndex) {
			return;
		}
		//VLR
		System.out.println(nodes[current]); // �湮 ���� ó�� -> ������ȸ
		dfs(current*2);
		//System.out.println(nodes[current]); // �湮 ���� ó�� -> ������ȸ
		dfs(current*2+1);
		//System.out.println(nodes[current]); // �湮 ���� ó�� -> ������ȸ
		
	}

	//���� ��ȸ
	public void inorder(int current) {
		if(current > lastIndex) {
			return;
		}
		//VLR
		inorder(current*2);
		System.out.println(nodes[current]); // �湮 ���� ó�� -> ������ȸ
		inorder(current*2+1);
	}
	
	//���� ��ȸ
	public void postorder(int current) {
		if(current > lastIndex) {
			return;
		}
		//VLR
		postorder(current*2);
		postorder(current*2+1);
		System.out.println(nodes[current]); // �湮 ���� ó�� -> ������ȸ
	}
}