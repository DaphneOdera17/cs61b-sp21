package gitlet;

// TODO: any imports you need here
import java.io.Serializable;
// TODO: You'll likely use this in this class
import java.util.Date;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author Birdy
 */

/** Serializable 可以让我们存储 arbitrary objects */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */
    /** The message of this Commit. */
    private String message;

    /* TODO: fill in the rest of this class. */
    private Date date;
    private String parentID;

    public Commit(Date d, String m, String p) {
        date = d;
        message = m;
        parentID = p;
    }


}
