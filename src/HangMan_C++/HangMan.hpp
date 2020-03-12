#include <string>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <iostream>
#include <algorithm>
#include <cstring>

namespace Container
{
    std::vector<std::string> const WordsToGuess = {"car", "wash", "operations"};
}

class Secret final
{
    std::string const & WordToGuess;
    int guessedLetters = 0;
    bool * guessed = nullptr;
    std::string const & GetWord() const
    {
        std::srand(unsigned(std::time(0)));
        return Container::WordsToGuess[std::rand() % Container::WordsToGuess.size()];
    }

public:
    Secret() : WordToGuess(GetWord()), guessed(new bool[WordToGuess.length()]) { std::memset(guessed, false, WordToGuess.length()); }
    Secret(Secret const & s) = delete;

    bool isHit(char c)
    {
        bool isHit = false;
        int const len = WordToGuess.length();
        for (int i = 0; i != len; ++i)
        {
            if (c == WordToGuess[i] && !guessed[i])
            {
                guessed[i] = true;
                isHit = true;
                ++guessedLetters;
            }
        }

        return isHit;
    }

    bool isDone() const
    {        
        return guessedLetters == WordToGuess.length();
    }

    void out() const 
    {
        int const len = WordToGuess.length();
        for (int i = 0; i != len; ++i)
        {
            if (guessed[i])
            {
                std::cout << WordToGuess[i];
            }
            else
            {
                std::cout << '_';
            }            
        }

        std::cout << '\n';
    }
    std::string const & result() const { return WordToGuess; }
};

class Guess final
{
public:
    Guess() {}
    char inputChar()
    {
        std::cout << "Enter letter: \n";
        char x = 0;
        std::cin >> x;
        return x;
    }
};


class CheckGuess final
{
    Guess guess;
    Secret & secret;

public:
    CheckGuess(Guess g, Secret & s) : secret(s), guess(g) {}

    bool isGuessed()
    {
        char c = guess.inputChar();
        if (secret.isHit(c))
        {
            std::cout << "HIT!\n";
            secret.out();
            if (secret.isDone())
            {
                std::cout << "You WIN!\n";
                return true;
            }
            else
                return false;
            
        }
        
        std::cout << "MISS!\n";
        return false;
    }
};

class Attempts final
{
    CheckGuess check;
    int max = 0;

public:
    Attempts(CheckGuess c, int m) : check(c), max(m) {}
    bool isGuessed()
    {
        int currentAttempt = 1;
        while (currentAttempt <= max && !check.isGuessed())
        {
            std::cout << "Current attempt: " << currentAttempt << " of: " << max << '\n';
            ++currentAttempt;
        }

        return currentAttempt <= max;
    }
};


class FareWell final
{
    Attempts attempt;
    Secret & secret;

public:
    FareWell(Attempts a, Secret & s) : attempt(a), secret(s) {}
    void say()
    {
        if (!attempt.isGuessed())
        {
            std::cout << "You lose. Word was: " << secret.result() << '\n';
        }
    }
};

