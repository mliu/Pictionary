package com.example.pictionary;

import android.os.Parcel;

import android.os.Parcelable;

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * // -------------------------------------------------------------------------
 * /** This class is going to be used as our queue structure for the lines
 * drawn, so they can be removed in order
 *
 * @param <E>
 * @author Christopher Deisher (cdd5)
 * @version Apr 16, 2014
 */
public class DrawQueue<E>
    implements Queue<E>, Parcelable
{
    private ArrayList<E> queue;


    /**
     * Constructor
     */
    public DrawQueue()
    {
        queue = new ArrayList<E>();
    }

    // ----------------------------------------------------------
    /**
     * Create a new DrawQueue object from a parcel.
     * @param in the parcelable drawqueue object
     */
    public DrawQueue(Parcel in) {
        this();
        readFromParcel(in);
    }


    /**
     * Unsupported
     */
    public boolean addAll(Collection<? extends E> arg0)
    {

        throw new UnsupportedOperationException(
            "We don't support this operation");

    }


    /**
     * Clears the queue
     */
    public void clear()
    {
        queue.clear();
    }


    /**
     * checks to see if the object is in the queue
     *
     * @param object
     *            the object
     * @return true/false
     */
    public boolean contains(Object object)
    {
        for (int i = 0; i < queue.size(); i++)
        {
            if (queue.get(i).equals(object))
            {
                return true;
            }
        }
        return false;
    }


    /**
     * checks to see if multiple items are contained
     *
     * @param ourobj
     *            the objects
     * @return t/f
     */
    public boolean containsAll(Collection<?> ourobj)
    {
        int count = 0;
        for (Object obj : ourobj)
        {
            for (int i = 0; i < queue.size(); i++)
            {
                if (queue.get(i).equals(obj))
                {
                    count++;
                    i = queue.size();
                }
            }
        }
        if (count == ourobj.size())
        {
            return true;
        }
        return false;
    }


    /**
     * Sees if array is empty
     *
     * @return t/f
     */
    public boolean isEmpty()
    {
        if (queue.size() == 0)
            return true;

        return false;
    }


    /**
     * returns a new iterator
     *
     * @return the iterator
     */
    public Iterator<E> iterator()
    {

        return queue.iterator();
    }


    /**
     * removes an object
     *
     * @param object
     *            the object to remove
     * @return whether it was succesfully returned
     */
    public boolean remove(Object object)
    {
        for (int j = 0; j < queue.size(); j++)
        {
            if (object.equals(queue.get(j)))
            {
                queue.remove(j);
                return true;
            }
        }
        return false;
    }


    /**
     * removes an object
     *
     * @param objects
     *            the object to remove
     * @return whether they were succesfully returned
     */
    public boolean removeAll(Collection<?> objects)
    {
        int count = 0;
        for (Object obj : objects)
        {
            if (this.remove(obj))
            {
                count++;
            }
        }
        if (count == objects.size())
            return true;
        return false;
    }


    /**
     * Unsupported
     *
     * @param arg0
     *            useless
     * @return nothing
     */
    public boolean retainAll(Collection<?> arg0)
    {
        throw new UnsupportedOperationException(
            "We don't support this operation");

    }


    /**
     * returns the size of the queue
     *
     * @return size
     */
    public int size()
    {
        return queue.size();
    }


    /**
     * Unsupported
     *
     * @return exception
     */
    public Object[] toArray()
    {
        throw new UnsupportedOperationException(
            "We don't support this operation");

    }


    /**
     * Unsupported
     *
     * @param array
     *            stop
     * @return it won't end well
     */
    public <T> T[] toArray(T[] array)
    {
        throw new UnsupportedOperationException(
            "We don't support this operation");

    }


    /**
     * add an element
     *
     * @param e
     *            the element
     * @return success?
     */
    public boolean add(E e)
    {
        queue.add(e);
        return true;
    }


    /**
     * Unsupported
     *
     * @return errors
     */
    public E element()
    {
        throw new UnsupportedOperationException(
            "We don't support this operation");
    }


    /**
     * Unsupported
     *
     * @return errors
     * @param e
     *            stuff
     */
    public boolean offer(E e)
    {
        throw new UnsupportedOperationException(
            "We don't support this operation");

    }


    /**
     * returns the object at the front of the queue
     */
    public E peek()
    {

        return queue.get(0);
    }


    /**
     * unsupported
     *
     * @return useless
     */
    public E poll()
    {
        throw new UnsupportedOperationException(
            "We don't support this operation");
    }


    /**
     * returns the item at the front and removes it
     */
    public E remove()
    {
        return queue.remove(0);
    }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel out, int arg1) {
        out.writeTypedList((ArrayList<DrawObject>) queue);
    }

    public static final Parcelable.Creator<DrawQueue<DrawObject>> CREATOR = new Parcelable.Creator<DrawQueue<DrawObject>>() {

        public DrawQueue<DrawObject> createFromParcel(Parcel source){
            return new DrawQueue<DrawObject>(source);
        }

        public DrawQueue<DrawObject>[] newArray(int size){
            return new DrawQueue[size];
        }
    };

    private void readFromParcel(Parcel in) {
        in.readTypedList((ArrayList<DrawObject>) queue, DrawObject.CREATOR);
    }
}
