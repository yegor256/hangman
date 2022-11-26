using System.Collections;
using System;
using System.Reflection;
using System.Linq;

namespace HangmanGame.Letter
{
    public class LetterComparer : IComparer
    {
        public int Compare(object x, object y)
        {
            if (x is VisibleLetter xv && y is VisibleLetter yv)
            {
                return xv.Value().CompareTo(yv.Value());
            }
            else if (x is HiddenLetter xh && y is HiddenLetter yh)
            {
                return xh.Value().CompareTo(yh.Value());
            }
            else
            {
                return -1;
            }
        }
    }
}
