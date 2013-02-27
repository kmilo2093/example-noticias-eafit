<?php

class Comment {

    private $id;
    private $id_news;
    private $User;
    private $date;
    private $comment;

    function __construct($id, $id_news, $User, $date, $comment) {
        $this->id = $id;
        $this->id_news = $id_news;
        $this->User = $User;
        $this->date = $date;
        $this->comment = $comment;
    }

    public function toArray() {
        return array(
                'id' => $this->getId(),
                'id_news' => $this->getId_news(),
                'User' => ArrayHelper::toArrayObject($this->getUser()),
                'date' => $this->getDate(),
                'comment' => $this->getComment()
        );
    }

    static public function getCommentObject($object) {
        if (property_exists($object, "Comment")) {
            $object = $object->Comment;
        }
        return new Comment(
                $object->id, $object->id_news, User::getUserObject($object->User), $object->date, $object->comment
        );
    }

// <editor-fold defaultstate="collapsed" desc="Get and Sets">
    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        $this->id = $id;
    }

    public function getId_news() {
        return $this->id_news;
    }

    public function setId_news($id_news) {
        $this->id_news = $id_news;
    }

    public function getUser() {
        return $this->User;
    }

    public function setUser($User) {
        $this->User = $User;
    }

    public function getDate() {
        return $this->date;
    }

    public function setDate($date) {
        $this->date = $date;
    }

    public function getComment() {
        return $this->comment;
    }

    public function setComment($comment) {
        $this->comment = $comment;
    }

    // </editor-fold>
}

?>
