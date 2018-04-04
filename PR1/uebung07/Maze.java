package pr1.uebung07;
import static pr.MakeItSimple.*;

public class Maze {
	static void findWay(char[][] field){
		boolean foundStart =false;
		int i = 0;
		int j= 0;
		for(i= 0; i < field.length;i++){
			for(j = 0 ; j<field[i].length;j++){
				if(field[i][j] == 'S'){
					findWayRecursive(field,j,i);
					foundStart = true;
				}
 			}
		}
		if(!foundStart){
			println("Kein Start gefunden");
			throw new PRException("Kein Start gefunden");
		}
	}
	
//	static boolean 
	
	static boolean findWayRecursive(char[][] field, int row, int col){
		boolean wayIsThere = false;
		field[col][row] = '.';
		
		if(isExit(field, col, row-1)){
			field[col][row-1] = 'E';
			wayIsThere = true;
			return true;
		}
		if(isExit(field, col, row+1)){
			field[col][row+1] = 'E';
			wayIsThere = true;
			return true;
		}
		if(isExit(field, col+1, row)){
			field[col+1][row] = 'E';
			wayIsThere = true;
			return true;
		}
		if(isExit(field, col-1, row)){
			field[col-1][row] = 'E';
			wayIsThere = true;
			return true;
		}
		
		if(isFree(field, col, row-1)){
			findWayRecursive(field,row-1,col);
			wayIsThere = true;
		}
		else if(isFree(field, col, row+1)){
			findWayRecursive(field,row+1,col);
			wayIsThere = true;
		}
		else if(isFree(field, col+1, row)){
			findWayRecursive(field,row,col+1);
			wayIsThere = true;
		}
		else if(isFree(field, col-1, row)){
			findWayRecursive(field,row,col-1);
			wayIsThere = true;
		}
		else{
			return false;
		}
		
		if(!wayIsThere){
			println("Kein weiterer Schritt möglich");
			throw new PRException("Kein weiterer Schritt möglich");
		}
		return false;
		
	}
	
	static boolean isFree(char[][] field, int col, int row){
		if(0 <= col && col <field.length
			&& 0 <= row && row <field[0].length){
			if(field[col][row] == ' ' || field[col][row] == 'S'){
				return true;
			}
		}
		return false;
	}
	static boolean isExit(char[][] field, int col, int row){
		if(col == 0 || col == (field.length-1) ||
			row == 0 || row == (field[0].length-1)){
			if(field[col][row] == ' '){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * 1. findWay
 * -> "S" finden
 * an findWayRecursive(field, row, col) übergeben
 * 
 * 2. findWayRecursive
 * hilfMethode isFree?
 * 
 * Maze
 * Kein S
 * Ausgang nicht erreichbar
 * 
 * String
 * Split
 * ein trennzeichen ->2array
 * Ararys vorne hinte
 * String nur trennzeichen 
 * 
 * 
*/
