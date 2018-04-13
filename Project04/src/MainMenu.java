import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class to access and update the songs in a linked list of songs.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class MainMenu {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(System.in);
		File file = new File("Playlist.txt");
		LinkedList list = new LinkedList();
		try{
			Scanner fileScan = new Scanner(file);
			while (fileScan.hasNextLine()){
				String line = fileScan.nextLine();
				String [] l = line.split(",");
				Song sing = new Song(l[0], l[1], l[2], l[3]);
				list.add(sing);
			}
			fileScan.close();
		} catch (FileNotFoundException fnf){
			System.out.println("File was not found.");
		}

		int choice = 0;
		boolean flag = true;
		do{
			System.out.println("1.  Search");
			System.out.println("2.  Add a new song");
			System.out.println("3.  Remove a song");
			System.out.println("4.  Update song information");
			System.out.println("5.  Print the number of songs in the list");
			System.out.println("6.  Print all of the songs");
			System.out.println("7.  Quit.");
			boolean testInput = true;
			while(testInput){
				try
				{
					choice = input.nextInt();
					testInput = false;
				}
				catch (InputMismatchException im){
					input.next();
					System.out.println("Invalid Input");
				}
			}
			System.out.println();

			while (choice < 1 || choice > 7){
				System.out.println("Please enter \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", or \"7\".");
				choice = input.nextInt();
			}
			switch(choice){
			case 1:
				System.out.println("1.  Search by song title");
				System.out.println("2.  Search by artist name");
				System.out.println("3.  Search by album title");
				System.out.println("4.  Search by index");
				System.out.println();

				int search = input.nextInt();
				if (search == 1){
					System.out.println("Enter the song title:");
					input.nextLine();
					String songTitle = input.nextLine();
					System.out.println();
					if (list.searchTitle(songTitle) != null){
						System.out.println("Song was found: ");
						System.out.println(list.searchTitle(songTitle));
					} else{
						System.out.println("Song was not found.");
					}
				} else if (search == 2){
					System.out.println("Enter the artist's name:");
					System.out.println();
					input.nextLine();
					String artistName = input.nextLine();
					if (list.searchArtist(artistName) != null){
						System.out.println("Song was found: ");
						System.out.println(list.searchArtist(artistName));
					} else{
						System.out.println("Song was not found.");
					}
				} else if (search == 3){
					System.out.println("Enter the album title:");
					System.out.println();
					input.nextLine();
					String albumTitle = input.nextLine();
					if (list.searchAlbum(albumTitle) != null){
						System.out.println("Song was found: ");
						System.out.println(list.searchAlbum(albumTitle));
					} else{
						System.out.println("Song was not found.");
					}
				} else if (search == 4){
					System.out.println("Enter the index number:");
					System.out.println();
					int indexNum = input.nextInt();
					if (list.searchIndex(indexNum) != null){
						System.out.println("Song was found: ");
						System.out.println(list.searchIndex(indexNum));
					} else{
						System.out.println("Invalid index");
					}
				} else{
					System.out.println("Invalid input");
				}
				break;

			case 2:
				System.out.println("Enter the song title");
				input.nextLine();
				String songTitle = input.nextLine();

				System.out.println("Enter the name of the artist");
				String artistName = input.nextLine();

				System.out.println("Enter the album title");
				String albumTitle = input.nextLine();

				System.out.println("Enter the length of the song");
				String songLength = input.nextLine();
				System.out.println();

				Song newSong = new Song(songTitle, artistName, albumTitle, songLength);
				System.out.println(newSong);
				list.add(newSong);
				break;

			case 3:
				System.out.println("1.  Remove by song title");
				System.out.println("2.  Remove by index");
				int rem = input.nextInt();

				if (rem == 1){
					System.out.println("Enter the song title: ");
					input.nextLine();
					String songT = input.nextLine();
					list.removeTitle(songT);
				} else if (rem == 2){
					System.out.println("Enter the index number: ");
					input.nextLine();
					int in = input.nextInt();
					list.removeIndex(in);
				} else{
					System.out.println("Invalid input");
				}
				break;

			case 4:
				System.out.println("Enter the name of the song you would like to modify");
				input.nextLine();
				String songChoice = input.nextLine();
				System.out.println();

				if (list.searchTitle(songChoice) == null){
					System.out.println("Song was not found.");
				} else{
					Song mod = list.searchTitle(songChoice);
					System.out.println("1.  Modify the song title");
					System.out.println("2.  Modify the artist's name");
					System.out.println("3.  Modify the album title");
					System.out.println("4.  Modify the length");
					System.out.println();

					int modify = input.nextInt();
					if (modify == 1){
						System.out.println("Input the updated song title: ");
						input.nextLine();
						mod.setTitle(input.nextLine());
						System.out.println();
					} else if (modify == 2){
						System.out.println("Input the updated artist: ");
						input.nextLine();
						mod.setArtist(input.nextLine());
						System.out.println();
					} else if (modify == 3){
						System.out.println("Input the updated album title: ");
						input.nextLine();
						mod.setTitle(input.nextLine());
						System.out.println();
					} else if (modify == 4){
						System.out.println("Input the updated song length: ");
						input.nextLine();
						mod.setLength(input.nextLine());
						System.out.println();
					} else{
						System.out.println("Invalid input");
					}
				}
				break;

			case 5:
				System.out.println("There are " +list.size() +" songs in the list.");
				System.out.println();
				break;

			case 6:
				System.out.println("1.  Print all songs by artist");
				System.out.println("2.  Print all songs by title");
				System.out.println("3.  Print all songs by album");
				int print = input.nextInt();
				if (print == 1){
					System.out.println(list);
				} else if (print == 2){

				} else if (print == 3){

				} else{
					System.out.println("Invalid input");
				}
				break;

			case 7:
				try {
					PrintWriter writer = new PrintWriter("FinalPlaylist.txt");
					for (int i = 0; i < list.size(); i++){
						writer.println(list.get(i).getValue());
					}
					writer.close();
				}catch(FileNotFoundException fnf){
					System.out.println("File was not found");
				}
				flag = false;
				break;

			default:
				System.out.println("Input is invalid.");
			}
		} while (flag != false);
	}
}
