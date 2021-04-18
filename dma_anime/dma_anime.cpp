/* C++ Program: Anime Shows + Number of Episodes */

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

// Declare classes
class anime
{
	public:
		string anime_name;
		int episodes;
};

class anime_shows
{
	public:
		anime_shows();	// Default constructor
		~anime_shows();	// Destructor
		void Print_Shows();
		
	private:
		int count;
		int max;
		anime *nakama;	// Dynamic array
};

// Define functions
anime_shows::anime_shows()
{
	// Initialize private variables
	count = 0;
	max = 12;
	// Create nakama
	nakama = new anime[max];
	// Declare anime variables
	string anime_name;
	int episodes;
	// Open file
	ifstream deathNote;
	deathNote.open("anime_shows.txt", ios::in);
	// Read file
	while(!deathNote.eof())
	{
		deathNote >> anime_name >> episodes;
		
		nakama[count].anime_name = anime_name;
		nakama[count].episodes = episodes;
		count++;
	}
	// Close file
	deathNote.close();
}

anime_shows::~anime_shows()
{
	delete [] nakama;
}

void anime_shows::Print_Shows()
{
	int i;
	
	for(i=0; i<=count; i++)
	{
		cout << nakama[i].anime_name << nakama[i].episodes << endl;
	}
}
// Main program
int main()
{
	cout << "\n*************************************************************" << endl;
	cout << "\n\tFavorite Animes & Their Number of Episodes..." << endl;
	// Copy data from class
	anime_shows bleach;
	bleach.Print_Shows();
	
	cout << "\n***************************************************************" << endl;
	
	return 0;
}
