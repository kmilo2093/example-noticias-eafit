<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of User
 *
 * @author Rodrigo
 */
class User {

    private $id;
    private $username;
    private $password;

    function __construct($id, $username, $password) {
        $this->id = $id;
        $this->username = $username;
        $this->password = $password;
    }

    function toArray() {
        return array(
                'id' => $this->id,
                'username' => $this->username,
                'password' => $this->password
        );
    }

    static function getUserObject($object) {
        if (property_exists($object, "User")) {
            $object = $object->User;
        }
        return new User(
                $object->id, $object->username, $object->password
        );
    }

    // <editor-fold defaultstate="collapsed" desc="Get and Sets">
    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        $this->id = $id;
    }

    public function getUsername() {
        return $this->username;
    }

    public function setUsername($username) {
        $this->username = $username;
    }

    public function getPassword() {
        return $this->password;
    }

    public function setPassword($password) {
        $this->password = $password;
    }

    // </editor-fold>
}

?>
