using System;

namespace HangmanGame.Letter
{
    public class HiddenLetter : ILetter
    {
        private readonly char _l;

        public HiddenLetter(char l)
        {
            _l = l;
        }

        public char Value()
        {
            return _l;
        }

        public char Print()
        {
            return '?';
        }

        public bool Hidden() => true;

        public ILetter Open(char guess)
        {
            if (guess == _l)
            {
                return new VisibleLetter(_l);
            }
            else
            {
                return this;
            }
        }
    }
}
