package uebung04;

import static pr.MakeItSimple.*;

public class MenueImplementation {

	public static void main(String[] args) {
		print("Welche Order sollen Ihre Bäume haben? ");
		int order = readInt();
		BTree[] trees = new BTree[5];
		for (int i = 0; i < trees.length; i++) {
			trees[i] = new MyBTree(order);
		}
		println("Sie haben 5 Baeume mit der Order" + order + "zur Verfuegung mit denen Sie arbeiten koennen");
		println("Auswahl ueber eine Zahl von 1-5: ");

		int userChoiceTree = readInt() - 1;

		println("Welche Aktion moechten Sie mit dem ausgewaehlten Baum ausfuehren?");
		println("1: Einen Wert einfuegen.");
		println("2: Einen Baum aus einer Datei einfuegen.");
		println("3: Pruefen, ob ein Wert im Baum ist.");
		println("4: Einen Wert aus dem Baum loeschen.");
		println("5: Hoehe des Baums ausgeben.");
		println("6: Groese des Baums ausgeben.");
		println("7: Maximalen Wert im Baum ausgeben.");
		println("8: Minimalen Wert im Baum ausgeben.");
		println("9: Ausgeben ob der Baum leer ist.");
		println("10: Alle Werte eines Baumes zum derzeitigen hinzufuegen.");
		println("11: Baum in Inorder ausgeben.");
		println("12: Baum in Preorder ausgeben.");
		println("13: Baum in Postorder ausgeben.");
		println("14: Baum in Levelorder ausgeben.");
		println("15: Einen anderen Baum waehlen.");
		println("16: Beenden.");
		print("Eingabe ueber die Nummer des Befehls: ");

		int userChoice;
		do {
			print("Eingabe ueber die Nummer des Befehls: ");
			userChoice = readInt();
			switch (userChoice) {
			case 1:
				print("Welcher Wert soll eingefuegt werden: ");
				if (trees[userChoiceTree].insert(readInt()))
					println("Der Wert wurde erfolgreich eingefuegt");
				else
					println("Der Wert ist bereits im Baum");
				break;
			case 2:
				print("Geben Sie den Dateinamen an: ");
				trees[userChoiceTree].insert(readString());
				break;
			case 3:
				print("Den gesuchten Wert angeben: ");
				if (trees[userChoiceTree].contains(readInt()))
					println("Der Wert ist im Baum");
				else
					println("Der Wert ist nicht im Baum");
				break;
			case 4:
				print("Welchen Wert moechten Sie loeschen:");
				trees[userChoiceTree].delete(readInt());
				break;
			case 5:
				println("Die Hoehe des Baums ist: " + trees[userChoiceTree].height() + ".");
				break;
			case 6:
				println("Size " + trees[userChoiceTree].size() + ".");
				break;
			case 7:
				println("Der goesste Wert im Baum ist: " + trees[userChoiceTree].getMax() + ".");
				break;
			case 8:
				println("Der kleinste Wert im Baum ist: " + trees[userChoiceTree].getMin() + ".");
				break;
			case 9:
				if (trees[userChoiceTree].isEmpty())
					println("Ja der Baum ist leer");
				else
					println("Nein der Baum ist nicht leer");
				break;
			case 10:
				print("Welchen Baum moechten Sie zum aktuellen hinzufuegen(1-5): ");
				int treeToBeInserted = readInt() - 1;
				trees[userChoiceTree].addAll((MyBTree) trees[treeToBeInserted]);
				break;
			case 11:
				trees[userChoiceTree].printInorder();
				println();
				break;
			case 12:
				trees[userChoiceTree].printPreorder();
				println();
				break;
			case 13:
				trees[userChoiceTree].printPostorder();
				println();
				break;
			case 14:
				trees[userChoiceTree].printLevelorder();
				println();
				break;
			case 15:
				print("Welchen Baum moechten Sie waehlen (1-5):");
				userChoiceTree = readInt() - 1;
				break;
			case 16:
				println("Ende des Programms");
				break;
			default:
				println("Ungueltige Eingabe.");
				break;
			}
		} while (userChoice != 19);
	}

}
