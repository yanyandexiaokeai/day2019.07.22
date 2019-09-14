public class Article {
    String title;
    String autor;
    String content;
    String publishAt;

    @Override

    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }

        if (!(obj instanceof Article)){
            return false;
        }

        if (obj == this){
            return true;
        }

        Article a = (Article)obj;
        if (!title.equals(a.title)){
            return false;
        }

        if (!autor.equals(a.autor)){
            return false;
        }

        if(!content.equals(a.content)){
            return false;
        }
        return publishAt.equals(a.publishAt);
    }
}
