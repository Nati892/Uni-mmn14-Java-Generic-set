import java.util.ArrayList;
import java.util.Iterator;

public class Set<T> {
    private ArrayList<T> _mySet;


    /**
     *
     */
    public Set() {
        _mySet = new ArrayList<T>();
    }

    /**
     * constructs a set from a given array
     * the set will not have any duplicates
     *
     * @param other_set an array the same type of the generic class's type
     */
    public Set(T[] other_set) {
        _mySet = new ArrayList<T>();
        for (int i = 0; i < other_set.length; i++) {
            if (other_set[i] != null) {
                T curr = other_set[i];
                if (!search(curr)) {
                    _mySet.add(curr);
                }
            }
        }
    }

    /**
     * @param otherSet
     */
    public void union(Set<T> otherSet) {

        Iterator<T> oIterator = otherSet.iterator();
        if (oIterator == null)
            return;

        while (oIterator.hasNext()) {
            T curr = oIterator.next();
            if (!search(curr)) {
                _mySet.add(curr);
            }
        }
    }

    /**
     * @param otherSet
     */
    public void intersect(Set<T> otherSet) {

        Iterator<T> thisIterator = _mySet.iterator();

        if (thisIterator == null)
            return;

        while (thisIterator.hasNext()) {
            T curr = thisIterator.next();

            if (!otherSet.isMember(curr)) {
                thisIterator.remove();
            }
        }

    }

    /**
     * null counts as an empty set which is a subset of every other set
     *
     * @param otherSet
     * @return
     */

    public boolean isSubset(Set<T> otherSet) {
        boolean result = true;

        Iterator<T> otherIterator = otherSet.iterator();

        if (otherIterator != null) {
            while (otherIterator.hasNext() && result == true) {
                T curr = otherIterator.next();
                if (!this.isMember(curr)) {
                    result = false;
                }
            }
        }
        return result;
    }


    //this function checks if found a specific object in the arrayList

    /**
     * @param member
     * @return
     */
    public boolean isMember(T member) {
        boolean result = false;
        if (member == null)
            return result;
        return (search(member));
    }

    /**
     * @param newMember
     */
    public void insert(T newMember) {
        if (newMember == null)
            return;

        if (!this.isMember(newMember))
            _mySet.add(newMember);
    }

    /**
     * @param rmMember
     */
    public void delete(T rmMember) {
        if (rmMember == null)
            return;

        if (this.isMember(rmMember))
            _mySet.remove(rmMember);
    }


    /**
     * this function returns an iterator for the set type
     *
     * @return Iterator for the set<T> type
     */
    public Iterator<T> iterator() {
        if (_mySet != null)
            return _mySet.iterator();
        else
            return null;
    }


    private boolean search(T toFind) {
        boolean result = false;
        if (_mySet == null)
            return result;
        Iterator<T> iterator = _mySet.iterator();
        while (iterator.hasNext() && !result) {
            T curr = iterator.next();
            if (curr.equals(toFind)) {
                result = true;
            }
        }
        return result;
    }

    public int size() {
        return _mySet.size();
    }

    public String toString() {
        return "Set: " + _mySet.toString();
    }


}

