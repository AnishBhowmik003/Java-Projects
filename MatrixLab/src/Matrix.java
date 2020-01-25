import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;
public class Matrix {

	private int[][] nums;
	
	
	
	//private int MyRows;
	//private int MyColumns;
	
	
	
	public Matrix(int rows, int columns) {
		nums = new int[rows][columns];
		//MyRows = rows;
		//MyColumns = columns;
		
	}
	
	public Matrix() {
		nums = new int[0][0];
	}
	
	public Matrix(int[][] x) {
		nums = x;
	}
	
	public Matrix(String path) throws IOException{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		Scanner reader = new Scanner(new File(path));
		while(reader.hasNext()) {
			ints.add(reader.nextInt());
		}
		int r = ints.get(0);
		int c = ints.get(1);
		
		nums = new int[r][c];
		int x = 2;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				nums[i][j] = ints.get(x);
				x++;
			}
		}
		reader.close();
	}
	
	public void randFill(int maxRows, int maxCols, int maxNum) {
		Random bob = new Random();
		int rows = bob.nextInt(maxRows-1)+1;
		int cols = bob.nextInt(maxCols-1) + 1;
		nums = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				nums[i][j] = bob.nextInt(maxNum);
			}
		}
		
	}
	
	public int[][] getNums() {
		return nums;
	}
	
	public boolean ChAddSubt(Matrix m2) {
		if(m2.getNumColumns() == this.getNumColumns() && m2.getNumRows() == this.getNumRows()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getNum(int row, int col) {
		int x = this.getNums()[row][col];
		return x;
	}
	
	
	public Matrix add(Matrix m2) {
		if (ChAddSubt(m2) == true) {
			Matrix newMat = new Matrix(m2.getNumRows(), m2.getNumColumns());
			for(int i = 0; i < m2.getNumRows(); i++) {
				for(int j = 0; j < m2.getNumColumns(); j++) {
					//newMat[i][j] = this.getNums()[i][j] + m2.getNums()[i][j];
					newMat.setNum(i,  j, this.getNums()[i][j] + m2.getNums()[i][j]);
				}
			}
			return newMat;
		}
		else {
			return null;
		}
	}
	
	public Matrix subtract(Matrix m2) {
		if(ChAddSubt(m2) == true) {
			Matrix newMat = new Matrix();
			m2 = m2.scalarMultiply(-1);
			newMat = this.add(m2);
			return newMat;
		}
		else {
			return null;
		}
	}
	
	
	
	public Matrix multiply(Matrix m2) {
		if (this.ChMult(m2) == true) {
			Matrix newMat = new Matrix(this.getNumRows(), m2.getNumColumns());
			for(int i = 0; i < newMat.getNumRows(); i++) {
				for(int j = 0; j < newMat.getNumColumns(); j++) {
					int sum = 0;
					for(int k = 0; k < this.getNumColumns(); k++) {
						sum += this.getNums()[i][k] * m2.getNums()[k][j];
					}
					newMat.setNum(i, j, sum);
					
					
				}
			}
			return newMat;
		}
		else {
			return null;
		}
		
		
		
	}
	
	public Matrix scalarMultiply(int num) {
		Matrix newMat = new Matrix(nums);
		for(int i = 0; i < newMat.getNumRows(); i++) {
			for(int j = 0; j < newMat.getNumColumns(); j++) {
				newMat.setNum(i, j, num * (newMat.getNum(i, j)));
			}
		}
		
		return newMat;
		
	}
	
	public boolean ChMult(Matrix m2) {
		if(this.getNumColumns() == m2.getNumRows()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public int getNumRows() {
		int x = nums.length;
		return x;
	}
	
	public int getNumColumns() {
		int x = nums[0].length;
		return x;
	}
	
	
	
	public void setNum(int row, int col, int number) {
		nums[row][col] = number;
	}
	
	public String toString() {
		String output = "";
		for(int i = 0; i < getNumRows(); i++) {
			for(int j = 0; j < getNumColumns(); j++) {
				output += nums[i][j] + " ";
			}
			output += "\n";
		}
		return output;
	}
	
}
