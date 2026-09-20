public class Note {

    private int id;
    private String title;
    private String content;

    public Note(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String toFileFormat() {
        return id + "|" + title + "|" + content;
    }

    public void displayNote() {
        System.out.println("-------------------------");
        System.out.println("ID      : " + id);
        System.out.println("Title   : " + title);
        System.out.println("Content : " + content);
        System.out.println("-------------------------");
    }
}
