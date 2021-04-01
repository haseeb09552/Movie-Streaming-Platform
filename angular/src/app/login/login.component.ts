import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginUserData: any = {};
  error: any = {};

  constructor(private _auth: AuthService, private _router: Router) {}

  ngOnInit(): void {}

  loginUser() {
    this._auth.loginUser(this.loginUserData).subscribe(
      (res: any) => {
        if (res === 'admin') {
          console.log('Admin');

          localStorage.setItem('admin', 'true');
          this._router.navigate(['/admin/movies']);
        }
        localStorage.setItem('loggedIn', 'true');
        this._router.navigate(['/movies']);
      },
      (err: any) => (this.error = err)
    );
  }
}
