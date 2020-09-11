using System;

namespace HangmanGame.Letter
{
    public class VisibleLetter : ILetter
    {
        private readonly char _l;

        public VisibleLetter(char l)
        {
            _l = l;
        }

        public char Value()
        {
            return _l;
        }

        public char Print()
        {
            return _l;
        }

        public bool Hidden() => false;

        public ILetter Open(char guess)
        {
            return this;
        }
    }
}
