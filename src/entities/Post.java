package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    // private static é para ter apenas uma copia dessa instanciação na aplicação
    // inteira
    // para nao ter que instanciar em todas as classes
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private String title;
    private String contest;
    private Integer likes;

    // aqui faremos a associação, um post contem varios comentarios por isso a
    // criação da lista
    // a lista Comments foi criada e instanciada atraves o ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    public Post() {

    }

    public Post(Date moment, String title, String contest, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.contest = contest;
        this.likes = likes;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContest() {
        return contest;
    }

    public void setContest(String contest) {
        this.contest = contest;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    // em listas pode ter somente o GET mas nunca o SET
    public List<Comment> getComments() {
        return comments;
    }

    // ao inves de criar o set, criar o metodo de add e remover comentarios da lista
    // de comentario
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    // StringBuilder ela é muito mais customizada quando vai usar string grandes a
    // partir de varios strings pequenos
    // tostring nao seria viavel pois ocuparia mais memoria
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // vai concatenar outros strings com usando a função append
        sb.append(title + "\n");
        sb.append(likes);
        sb.append("  Likes -  ");
        sb.append(sdf.format(moment) + "\n");
        sb.append(contest + "\n");
        sb.append("Comments:\n");
        // fazer um for it para cada comment ser da lista ser adcionado no string
        // builder
        for (Comment c : comments) {
            sb.append(c.getText() + "\n");
        }
        return sb.toString(); // converter para topstring

    }

}
