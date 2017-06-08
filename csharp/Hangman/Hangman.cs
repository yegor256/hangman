using System;
using System.Collections.Generic;
using System.Text;

namespace Hangman
{
    public class Hangman : ISource<GameState>
    {
        public Hangman(ISource<char> source)
        {
            
        }

        public IObservable<GameState> Source()
        {
            throw new NotImplementedException();
        }
    }
}
