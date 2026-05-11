/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Ix Manuel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package event;

/**
 * Base decorator for distpatching events. It doesn't match any criteria 
 * and thus, it always dispatches an uncaught event. Upper levels of 
 * decoration can be exchanged indistinctly as long as the logic
 * in each condition doesn't depend on the lower one and this
 * proposition always must be true.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IfBase implements Dispatching {
        /**
         * An uncaught event from the begining.
         * @return Event uncaught
         */
	@Override
	public Event event() {		
		return new UncaughtEvent();
	}
}