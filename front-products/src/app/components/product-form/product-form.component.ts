import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-form',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css'],
})
export class ProductFormComponent {
  product = {
    id: '',
    name: '',
    price: 0,
    category: '',
  };

  constructor(private productService: ProductService) {}

  submitForm(): void {
    this.productService.createProduct(this.product).subscribe(() => {
      console.log('Producto creado exitosamente!!');
    });
  }
}
