using HangmanGame.Game;
using HangmanGame.Hangman;
using HangmanGame.Letters;
using HangmanGame.Word;
using HangmanGame.WordSource;
using System;
using System.Runtime.CompilerServices;

[assembly: InternalsVisibleTo("HangmanGameTests")]
namespace Hangman
{
    class Program
    {
        private static readonly int max = 5;
        private static readonly string[] WORDS = {
            "simplicity", "equality", "grandmother",
            "neighborhood", "relationship", "mathematics",
            "university", "explanation"
        };

        static void Main(string[] args)
        {
            new Game(new AliveHangman(new TargetWord(new InitialLetters(new RandomWordSource(WORDS, new Random()))), 5), Console.In, Console.Out).Start();
        }

        #region Old procedural-style version
        [Obsolete]
        private static void exec()
        {
            string word = WORDS[new Random().Next(WORDS.Length)];
            bool[] visible = new bool[word.Length];
            int mistakes = 0;
            try
            {
                bool done = true;
                while (mistakes < max)
                {
                    done = true;
                    for (int i = 0; i < word.Length; ++i)
                    {
                        if (!visible[i])
                        {
                            done = false;
                        }
                    }
                    if (done)
                    {
                        break;
                    }
                    Console.WriteLine("Guess a letter: ");
                    char chr = Console.ReadLine()[0];
                    bool hit = false;
                    for (int i = 0; i < word.Length; ++i)
                    {
                        if (word[i] == chr && !visible[i])
                        {
                            visible[i] = true;
                            hit = true;
                        }
                    }
                    if (hit)
                    {
                        Console.WriteLine("Hit!\n");
                    }
                    else
                    {
                        Console.WriteLine($"Missed, mistake {mistakes + 1} out of {max}");
                        ++mistakes;
                    }
                    Console.Write("The word: ");
                    for (int i = 0; i < word.Length; ++i)
                    {
                        if (visible[i])
                        {
                            Console.WriteLine(word[i]);
                        }
                        else
                        {
                            Console.WriteLine("?");
                        }
                    }
                }
                if (done)
                {
                    Console.WriteLine("You won");
                }
                else
                {
                    Console.WriteLine("You lost.");
                    Console.ReadLine();
                }
            }
            catch
            { }
        }
        #endregion
    }
}
