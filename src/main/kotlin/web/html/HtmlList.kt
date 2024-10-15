/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "HtmlList.kt" file from the KTML project.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package web.html

/**
 * # HtmlList
 *
 * An HTML list is an ordered collection of HTML elements that can make up a document.
 */
class HtmlList (
    subList: Collection<HtmlElement>
) : HtmlElement, MutableList<HtmlElement> {

    constructor(vararg elements: HtmlElement) : this(
        elements.toMutableList()
    )

    private val subList: MutableList<HtmlElement> = subList.toMutableList()

    override val size: Int get() = subList.size

    override fun clear() = subList.clear()

    override fun get(index: Int): HtmlElement = subList[index]

    override fun isEmpty(): Boolean = subList.isEmpty()

    override fun iterator(): MutableIterator<HtmlElement> = subList.iterator()

    override fun listIterator(): MutableListIterator<HtmlElement> = subList.listIterator()

    override fun listIterator(index: Int): MutableListIterator<HtmlElement> = subList.listIterator(index)

    override fun removeAt(index: Int): HtmlElement = subList.removeAt(index)

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<HtmlElement> = subList.subList(fromIndex, toIndex)

    override fun set(index: Int, element: HtmlElement): HtmlElement = subList.set(index, element)

    override fun retainAll(elements: Collection<HtmlElement>): Boolean = subList.retainAll(elements)

    override fun removeAll(elements: Collection<HtmlElement>): Boolean = subList.removeAll(elements)

    override fun remove(element: HtmlElement): Boolean = subList.remove(element)

    override fun lastIndexOf(element: HtmlElement): Int = subList.lastIndexOf(element)

    override fun indexOf(element: HtmlElement): Int = subList.indexOf(element)

    override fun containsAll(elements: Collection<HtmlElement>): Boolean = subList.containsAll(elements)

    override fun contains(element: HtmlElement): Boolean = subList.contains(element)

    override fun addAll(elements: Collection<HtmlElement>): Boolean = subList.addAll(elements)

    override fun addAll(index: Int, elements: Collection<HtmlElement>): Boolean = subList.addAll(index, elements)

    override fun add(index: Int, element: HtmlElement) = subList.add(index, element)

    override fun add(element: HtmlElement): Boolean = subList.add(element)

    override fun toString(): String {

        return subList.joinToString("")
    }

    override fun toPrettyString(): String {

        return subList.joinToString("\n") { it.toPrettyString() }
    }
}