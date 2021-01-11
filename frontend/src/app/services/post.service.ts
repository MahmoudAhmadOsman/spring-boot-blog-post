import { Post } from '../models/post.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class PostService {
  //Backend url
 private baseURL ="http://localhost:8080/api/v1/posts";

 constructor(private httpClient: HttpClient) { }


//Get all posts
  getPostsList(): Observable<Post[]> {
      return this.httpClient.get<Post[]>(`${this.baseURL}`);
  }


}
