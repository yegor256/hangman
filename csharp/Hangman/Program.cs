using System;
using System.IO;
using System.Linq;

namespace Hangman
{
    public class Program
    {
        private readonly Stream _input;
        private readonly Stream _output;
        private readonly int _max;
        private static readonly string[] WORDS = {
            "simplicity", "equality", "grandmother",
            "neighborhood", "relationship", "mathematics",
            "university", "explanation"
        };

        public Program(Stream input, Stream output, int max)
        {
            this._input = input;
            this._output = output;
            this._max = max;
        }

        public static void Main(string[] args)
        {
            new Program(Console.OpenStandardInput(), Console.OpenStandardOutput(), 5).Exec();
        }

        public void Exec()
        {
            string word = WORDS[new Random().Next(WORDS.Length)];
            bool[] visible = new bool[word.Length];
            int mistakes = 0;
            using(StreamWriter _out = new StreamWriter(this._output) { AutoFlush = true })
            {
                StreamReader scanner = new StreamReader(this._input);
                bool done = true;
                while (mistakes < this._max)
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
                    _out.WriteLine("Guess a letter: ");
                    char chr = scanner.ReadLine().ElementAt(0);
                    bool hit = false;
                    for (int i = 0; i < word.Length; ++i)
                    {
                        if(word[i] == chr && !visible[i])
                        {
                            visible[i] = true;
                            hit = true;
                        }
                    }
                    if (hit)
                    {
                        _out.WriteLine("Hit!");
                    }
                    else
                    {
                        _out.WriteLine(
                                "Missed, mistake #{0} out of {1}",
                                mistakes + 1, this._max
                             );
                        ++mistakes;
                    }
                    _out.Write("The word: ");
                    for(int i = 0; i < word.Length; ++i)
                    {
                        if(visible[i])
                        {
                            _out.Write(word[i]);
                        }
                        else
                        {
                            _out.Write("?");
                        }
                    }
                    _out.Write("\n\n");
                }
                if (done)
                {
                    _out.WriteLine("You won!");
                }
                else
                {
                    _out.WriteLine("You lost.");
                }
            }
        }
    }
}