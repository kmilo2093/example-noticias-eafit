<?php
include ('Service.php');

/**
 * NewsService provides the connection with the News service
 *
 * @author Rodrigo
 */
class NewsService extends Service {

    public function callService() {
        if (Service::checkParamPOST('News')) {
            return $this->createNews(json_decode($_POST['News']));
        } else if (Service::checkParamGET('id')) {
            return $this->getNewsById($_GET['id']);
        } else {
            return $this->getNews();
        }
    }

    public function includeSpecificFiles() {
        include('../model/News.php');
        include('../model/Comment.php');
        include('../model/User.php');
    }

    public function getNews() {
        return (Controller::getInstance()->getNews());
    }

    public function getNewsById($id) {
        return ArrayHelper::toArrayObject(Controller::getInstance()->getNewsById($id));
    }

    public function createNews($news) {
        $News = News::getNewsObject($news);
        return array('id' => Controller::getInstance()->createNews($News));
    }
}

/**
 * Important! This line is needed to instantiate the service
 */
new NewsService();
?>
