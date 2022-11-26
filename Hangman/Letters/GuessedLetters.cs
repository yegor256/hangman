using HangmanGame.Letter;
using System.Collections.Generic;
using System.Linq;

namespace HangmanGame.Letters
{
    public class GuessedLetters : ILetters
    {
        private readonly ILetter[] _letters;
        private readonly List<int> _cache;

        public GuessedLetters(ILetter[] letters)
        {
            _letters = letters;
            _cache = new List<int>();
        }

        public ILetter[] Show()
        {
            return _letters;
        }

        public int HiddensCount()
        {
            if (_cache.Count == 0)
            {
                _cache.Add(_letters.Where(x => x.Hidden()).Count());
            }
            return _cache[0];
        }
    }
}
