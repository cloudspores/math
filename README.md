# math

## Application of Shaping functions in a basic waveshaping synthesizer 
A basic waveshaping synthesizer consists of:
 
### Excitation Table
A matrix containing values for a cosine wave over unit period defined as:

x = cos Θ with Θ = wt

where t is time, w the radian frequency and Θ the phase angle.

Thus x varies with time within the range -1 <= x <= +1 or the signed unit interval.

### Shaping Table
A 1-D matrix containing values for a shaping function f with values within the signed unit interval.

### Waveform Synthesis
To synthesize a steady state spectrum:

Successive values f(x) are computed by performing a table lookup in the Shaping Table of successive values of x pulled out of the Excitation Table.

### Shaping Function
The function f must meet the following conditions:
- f must take a number in the range (-1, +1) i.e. the signed unit interval.
- f must return a result in the signed unite interval.

An infinite range of waveforms including all symmetric waveshapes can be produced using this method.

If the resultant waveform is g(Θ) then g(Θ) = f(x)

but x = cos Θ

       Θ = cos^-1(x)
hence f(x) = g(cos^-1(x))

To produce some desired waveshape g(Θ), f(x) can in principle be set as g(cos^-1(x))


### Implementation
The series of functions Tn known as Chebychev polynomials of the first kind can be shown to be very convenient wave-shaping functions.

The nth harmonic is produced when Tn is used as a shaping function.

Remembering that x =  cos Θ,

Tn(x) = Tn(cos Θ) 
      = cos Θ               -> the nth harmonic
      
      
The trigonometric expression above illustrates the convenience of employing Chebychev polynomials.

T0(x) = cos 0 = 1

T1(x) = cos Θ = x

A recursive formula for Tn + 1, with respect to Tn and Tn-1 can be derived thus:

cos u. cos v = (cos(u+v) + cos(u-v))/ 2

If u = n Θ and v = Θ

cos nΘ.cos Θ = (cos(nΘ+ Θ) + cos(cos nΘ - Θ))/ 2
             = (cos(n+1)Θ + cos(n-1)Θ)/ 2
             
where cos Θ = x and cos nΘ = Tn (cos Θ)

Hence x.Tn(x) = (Tn+1 (x) + Tn-1 (x))/ 2

and Tn+1 (x) = 2x.Tn (x) - Tn-1 (x)

which is the required recursive formula to calculate successive Tn:

T0(x) = 1

T1(x) = x

T2(x) = 2x^2 - 1

T3(x) = 4x^3 - 3x

T4(x) = 8x^4 - 8x^2 + 1

etc.


To create any steady-state spectrum, a linear combination of appropriate weighted functions is required.
Thus to synthesize a steady-state square wave spectrum:

f_square = (4/π).(T1(x) + (1/3).T3(x) + (1/5).T5(x) + ...)

Note that T0 represents a constant offset and may be disregarded for this purpose.
