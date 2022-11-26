using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HangmanGameTests
{
    internal class RandomChar
    {
        private const string _alphabet = "abcdefghijklmnopqrstuvwxyz";
        private readonly Random rnd;

        public RandomChar()
        {
            rnd = new Random();
        }

        public RandomChar(int seed)
        {
            rnd = new Random(seed);
        }

        public char Load()
        {
            int randomInd = rnd.Next(0, _alphabet.Length); // a-z
            return _alphabet[randomInd];
        }

        public char GetAnother(char a)
        {
            return GetAnother(new char[] { a });
        }

        public char GetAnother(char[] range)
        {
            HashSet<char> set = new HashSet<char>(range);
            char[] others = _alphabet.Where(x => !set.Contains(x)).ToArray();
            int randomInd = rnd.Next(0, others.Length);
            return others[randomInd];
        }
    }
}
