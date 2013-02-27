<?php

include ('Service.php');

class CommentService extends Service {

    public function callService() {
        if (Service::checkParamPOST('News')) {
            return $this->createComment(json_decode($_POST['Comment']));
        }
        getErrorArray('02', "No existe un servicio con estos parametros");
    }

    public function includeSpecificFiles() {
        include('../model/Comment.php');
        include('../model/User.php');
    }

    public function createComment($comment) {
        $Comment = Comment::getCommentObject($comment);
        return array('id' => Controller::getInstance()->createComment($Comment));
    }

}

new CommentService();
?>
