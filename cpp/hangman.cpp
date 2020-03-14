#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>
#include <ctime>


struct Word
{
    Word()
    {
        srand(time(NULL));
        word = allowedWords[ rand() % allowedWords.size() ];
    }

    std::vector<std::string> allowedWords = {
    "simplicity", "equality", "grandmother",
    "neighborhood", "relationship", "mathematics",
    "university", "explanation"
    };
    std::string word;
    
};

struct WordMap
{
    WordMap():
        w(),
        map(w.word.size(), false)
    {}

    bool IsGuessed()
    {
        for (const auto& it: map)
            if (!it)
                return false;
        return true;
    }

    bool CheckLetter(char l)
    {
        bool right = false;
        for (std::size_t i = 0; i < map.size(); ++i)
        {
            if (w.word[i] == l && !map[i])
            {
                map[i] = true;
                right = true;
            }
        }
        return right;
    }

    void ShowMap()
    {
        std::cout << "The word: ";
        for (std::size_t i = 0; i < map.size(); ++i)
        {
            std::cout << (map[i] ? w.word[i] : '?');
        }
        std::cout << std::endl << std::endl;
    }
    Word w;
    std::vector<bool> map;
};

struct Guess
{
    char GetLetter()
    {
        char letter = 0;
        std::cout << "Guess a letter: ";
        std::cin >> letter;
        return letter;
    }
};

struct Attempts
{
    Attempts(int t, Guess gs, WordMap wm):
        times(t),
        g(gs),
        w(wm)
    {}

    bool Step(int i)
    {
        if (w.CheckLetter(g.GetLetter()))
        { 
            std::cout <<"Hit" << std::endl;
            return true;
        }
        else
        {
            std::cout << "Missed, mistake #" << i+1 << " out of " << times << std::endl;
            return false;
        }
    }

    bool Do()
    {
        int mistakes = 0;
        while ( mistakes < times)
        {
            if (!Step(mistakes))
                mistakes++;

            w.ShowMap();

            if (w.IsGuessed())
                return true;
        }
        return false;
    }

    int times;
    Guess g;
    WordMap w;
};

struct Judge
{
    Judge(Attempts at):
        a(at)
    {}

    void Decide()
    {
        if (a.Do())
        {
            std::cout << "You won!" << std::endl;
        }
        else
            std::cout << "You lost." << std::endl;
    }

    Attempts a;
};

int main(int arc, char* argv[])
{
    Judge(Attempts(5, Guess(), WordMap())).Decide();

}


