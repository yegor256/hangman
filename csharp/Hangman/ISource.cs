using System;
using System.Collections.Generic;
using System.Text;

namespace Hangman
{
    public interface ISource<out T>
    {
        IObservable<T> Source();
    }
}
