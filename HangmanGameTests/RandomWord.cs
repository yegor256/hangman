using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HangmanGameTests
{
    internal class RandomWord
    {
        private readonly int _minLength;
        private readonly int _maxLength;
        private readonly RandomChar _rc;

        public RandomWord(int minLength, int maxLength)
        {
            _minLength = minLength;
            _maxLength = maxLength;
            _rc = new RandomChar();
        }

        public string Word()
        {
            int length = new Random().Next(_maxLength, _maxLength);
            return string.Concat(new char[length].Select(x => _rc.Load()));
        }
    }
}
