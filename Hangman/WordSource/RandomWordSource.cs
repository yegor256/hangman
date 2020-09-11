using System;
using System.Linq;

namespace HangmanGame.WordSource
{
    public class RandomWordSource : IWordSource
    {
        private readonly string[] _words;
        private readonly Random _random;
        private string _state;

        public RandomWordSource(string[] words, Random random)
        {
            _words = words;
            _random = random;
            _state = string.Empty;
        }

        public string Load()
        {
            if (string.IsNullOrEmpty(_state))
            {
                Reload();
            }
            return _state;
        }

        public void Reload()
        {
            string[] excluded = _words.Where(x => x != _state).ToArray();
            _state = excluded[_random.Next(excluded.Length)];
        }
    }
}
