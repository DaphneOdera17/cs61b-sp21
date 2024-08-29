package gitlet;

import java.io.File;
import java.util.Date;

import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *  @author Birdy
 *
 *  .gitlet /
 *      - objects/
 *          - blobs/
 *              -
 *          - commits/
 *              -
 *      - refs/
 *      - Storage/
 *          - STAGED_FILE
 *          - REMOVED_FILE
 *      - HEAD
 *
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");
    /** The .gitlet/objects directory. */
    public static final File OBJECTS_DIR = join(GITLET_DIR, "objects");
    /** The .gitlet/objects/blobs directory. */
    public static final File BLOBS_DIR = join(OBJECTS_DIR, "blobs");
    /** The .gitlet/objects/commits directory. */
    public static final File COMMITS_DIR = join(OBJECTS_DIR, "commits");
    /** The .gitlet/refs directory. */
    public static final File REFS_DIR = join(GITLET_DIR, "refs");
    /** The .gitlet/Stage directory. */
    public static final File STAGE_DIR = join(GITLET_DIR, "Stage");
    /** The .gitlet/HEAD. */
    public static final File HEAD = join(GITLET_DIR, "HEAD");
    /** The .gitlet/Stage/STAGED_FILE. */
    public static final File STAGED_FILE = join(STAGE_DIR, "STAGED_FILE");
    /** The .gitlet/Stage/REMOVED_FILE. */
    public static final File REMOVED_FILE = join(STAGE_DIR, "REMOVED_FILE");

    /* TODO: fill in the rest of this class. */

    /* 创建 .gitlet 目录 */
    public static void MakeDirectory() {
        // 当前目录已经存在 Gitlet 版本控制系统
        if(GITLET_DIR.exists()) {
            System.out.println("A Gitlet version-control system already exists in the current directory.");
            System.exit(0);
        } else {
            GITLET_DIR.mkdir();
            OBJECTS_DIR.mkdir();
            REFS_DIR.mkdir();
            BLOBS_DIR.mkdir();
            COMMITS_DIR.mkdir();
            STAGE_DIR.mkdir();
            Date time = new Date(0);
            Commit initialCommit = new Commit(time,"initial commit", null);

        }
    }
}
