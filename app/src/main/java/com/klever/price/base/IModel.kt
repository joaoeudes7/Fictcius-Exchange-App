package com.jdeve.mesanews.base

interface IModel {
    fun toDtoNetwork(): IDTONetwork
    fun toDtoLocal(): IDTOLocal
}