#include "HangMan.hpp"

int main()
{
    Secret secret{};

    FareWell{
        Attempts{
            CheckGuess{
                Guess{}, secret
            }, 10
        }, secret
    }.say();
    
    return true;
}