import java.io.*;
import java.util.Scanner;

public class SatPix {

	public static void main(String[] args) throws IOException
	{
		boolean[][] booleanArr = fileToBoolArray("satpix.in");
		int sizeOfLargestPasture;
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
		out.println(sizeOfLargestPasture);
		out.close();
		}
	
	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException
	{
//		//This helper method converts the input file into a 2D array of booleans
		Scanner s = new Scanner (new File(fileName));
		int col = s.nextInt();
		int row = s.nextInt();
		boolean[][] farm = new boolean[row][col];
		for (int x = 0; x < row; x++)
		{
			String thisSection = s.next();
			for (int y = 0; y < col; y++)
			{
				if (thisSection.charAt(y) == '*')
				{
					farm[x][y] = true;
				}
				else
				{
					farm[x][y] = false;
				}
			}
		}
		return farm;
	
	}

	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
	{
		//This recursive method employs the flood-fill algorithm to
		//count the size of a single pasture and "mark" it so it is not double-counted
		if (row >= 0
				&& col >= 0
				&& row < arr.length
				&& col < arr[0].length
				&& arr[row][col] == true)
		{
			arr[row][col] = false;
			
			return 1 + recursivelyMeasureAndMarkPasture(row - 1, col, arr) +
			recursivelyMeasureAndMarkPasture(row + 1, col, arr) +
			recursivelyMeasureAndMarkPasture(row, col + 1, arr) +
			recursivelyMeasureAndMarkPasture(row, col - 1, arr);
		}
		return 0;
		
	}
	
}
