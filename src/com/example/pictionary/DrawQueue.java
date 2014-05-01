package com.example.pictionary;

import java.util.NoSuchElementException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * // -------------------------------------------------------------------------
 * /** This class is going to be used as our queue structure for the lines
 * drawn, so they can be removed in order. If it is supposed to be parceled, the
 * class assumes you are passing drawObjects, otherwise, any element E is
 * acceptable
 *
 * @param <E>
 * @author Christopher Deisher (cdd5)
 * @version Apr 16, 2014
 */
public class DrawQueue<E> implements Queue<E>, Parcelable {
    private ArrayList<E> queue;

    /**
     * Constructor
     */
    public DrawQueue() {
        queue = new ArrayList<E>();
    }

    // ----------------------------------------------------------
    /**
     * Create a new DrawQueue object from a parcel.
     *
     * @param in
     *            the parcel drawqueue object
     */
    public DrawQueue(Parcel in) {
        this();
        readFromParcel(in);
    }

    /**
     * adds All elements in the list to the queue
     *
     * @param list
     *            List of things to add
     * @return if successfully added
     */
    public boolean addAll(Collection<? extends E> list) {
        return queue.addAll(list);

    }

    /**
     * Clears the queue
     */
    public void clear() {
        queue.clear();
    }

    /**
     * checks to see if the object is in the queue
     *
     * @param object
     *            the object
     * @return true/false
     */
    public boolean contains(Object object) {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).equals(object)) {
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
    public boolean containsAll(Collection<?> ourobj) {
        int count = 0;
        for (Object obj : ourobj) {
            for (int i = 0; i < queue.size(); i++) {
                if (queue.get(i).equals(obj)) {
                    count++;
                    i = queue.size();
                }
            }
        }
        if (count == ourobj.size()) {
            return true;
        }
        return false;
    }

    /**
     * Sees if array is empty
     *
     * @return t/f
     */
    public boolean isEmpty() {
        if (queue.size() == 0)
            return true;

        return false;
    }

    /**
     * returns a new iterator
     *
     * @return the iterator
     */
    public Iterator<E> iterator() {

        return queue.iterator();
    }

    /**
     * removes an object
     *
     * @param object
     *            the object to remove
     * @return whether it was succesfully returned
     */
    public boolean remove(Object object) {
        for (int j = 0; j < queue.size(); j++) {
            if (object.equals(queue.get(j))) {
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
    public boolean removeAll(Collection<?> objects) {
        int count = 0;
        for (Object obj : objects) {
            if (this.remove(obj)) {
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
     * @param list
     *            the list of things to retain
     * @return if successful
     */
    public boolean retainAll(Collection<?> list) {
        return queue.retainAll(list);

    }

    /**
     * returns the size of the queue
     *
     * @return size
     */
    public int size() {
        return queue.size();
    }

    /**
     * This method returns an array of everything in the queue
     *
     * @return an array of all objects in this queue
     */
    public Object[] toArray() {
        return queue.toArray();

    }

    /**
     * Returns an array containing all elements contained in this Queue. If the
     * specified array is large enough to hold the elements, the specified array
     * is used, otherwise an array of the same type is created. If the specified
     * array is used and is larger than this Queue, the array element following
     * the collection elements is set to null.
     *
     * @param array
     *            the array you want to contain elements
     * @return the new array
     */
    public <T> T[] toArray(T[] array) {
        return queue.toArray(array);

    }

    /**
     * add an element
     *
     * @param e
     *            the element
     * @return success?
     */
    public boolean add(E e) {
        queue.add(e);
        return true;
    }

    /**
     * Like peek, returns front element without removing, but throws an
     * NoSuchElement exception if empty
     *
     * @return the top element
     */
    public E element() {
        if (this.size() == 0) {
            throw new NoSuchElementException("The Queue is Empty");
        }
        return this.peek();
    }

    /**
     * Functions exactly like add, as we are not capacity-limited
     *
     * @return true if added
     * @param e
     *            the thing to add
     */
    public boolean offer(E e) {

        return this.add(e);
    }

    /**
     * returns the object at the front of the queue
     */
    public E peek() {

        return queue.get(0);
    }

    /**
     * Returns and removes the front of the queue, but returns null if empty
     *
     * @return the front of the queue
     */
    public E poll() {
        if (this.size() == 0) {
            return null;
        }
        return this.remove();

    }

    /**
     * returns the item at the front and removes it
     *
     * @return the front element
     */
    public E remove() {
        if (this.size() == 0) {
            throw new NoSuchElementException("Can't Remove from Empty Queue");
        }
        return queue.remove(0);
    }

    /**
     * This returns a int file descriptor
     *
     * @return FILE DESCRIPTOR INT
     */
    public int describeContents()
    {
        return CONTENTS_FILE_DESCRIPTOR;
    }

    /**
     * Writes to parcel
     *
     * @param out
     *            the parcel
     * @param arg1
     *            the int
     */
    public void writeToParcel(Parcel out, int arg1) {
        out.writeTypedList((ArrayList<DrawObject>) queue);
    }

    /**
     * Creates the queue via a parcelable object
     */
    public static final Parcelable.Creator<DrawQueue<DrawObject>> CREATOR =
            new Parcelable.Creator<DrawQueue<DrawObject>>() {
        public DrawQueue<DrawObject> createFromParcel(Parcel source) {
            return new DrawQueue<DrawObject>(source);
        }

        public DrawQueue<DrawObject>[] newArray(int size) {
            return new DrawQueue[size];
        }
    };

    /**
     * Reads from parcel
     *
     * @param in
     *            the Parcel
     */
    private void readFromParcel(Parcel in) {
        in.readTypedList((ArrayList<DrawObject>) queue, DrawObject.CREATOR);
    }
}
