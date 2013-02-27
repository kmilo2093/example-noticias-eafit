<?php

class News {

    private $id;
    private $title;
    private $brief;
    private $content;
    private $date;
    private $comments;

    function __construct($id, $title, $brief, $content, $date) {
        $this->id = $id;
        $this->title = $title;
        $this->brief = $brief;
        $this->content = $content;
        $this->date = $date;
        $this->comments = array();
    }

    public function addComment($Comment) {
        array_push($this->comments, $Comment);
    }

    public function toArray() {
        return array(
            'id' => $this->getId(),
            'title' => $this->getTitle(),
            'brief' => $this->getBrief(),
            'content' => $this->getContent(),
            'date' => $this->getDate(),
            'comments' => ArrayHelper::toArray($this->getComments())
        );
    }

    static public function getNewsObject($object) {
        if (property_exists($object, "News")) {
            $object = $object->News;
        }
        return new News(
                $object->id, $object->title, $object->brief, $object->content, $object->date
        );
    }

    // <editor-fold defaultstate="collapsed" desc="Get and Sets">

    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        $this->id = $id;
    }

    public function getTitle() {
        return $this->title;
    }

    public function setTitle($title) {
        $this->title = $title;
    }

    public function getBrief() {
        return $this->brief;
    }

    public function setBrief($brief) {
        $this->brief = $brief;
    }

    public function getContent() {
        return $this->content;
    }

    public function setContent($content) {
        $this->content = $content;
    }

    public function getDate() {
        return $this->date;
    }

    public function setDate($date) {
        $this->date = $date;
    }

    public function getComments() {
        return $this->comments;
    }

    public function setComments($comments) {
        $this->comments = $comments;
    }

    // </editor-fold>
}

?>
