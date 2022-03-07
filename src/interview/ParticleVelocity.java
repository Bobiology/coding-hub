package interview;

public class ParticleVelocity {
	public static void main(String[] args) {
		int[] particles = { 1, 3, 5, 7, 9 };
		System.out.println(particleVelocity(particles));
	}

 public static int particleVelocity(int[] particles) {
		int total_periods = 0, particles_size = particles.length;
		for (int i = 0; i < particles_size; i++) {
			for (int count = 0; i + 2 < particles_size
					&& particles[i + 1] - particles[i] == particles[i + 2] - particles[i + 1]; i++) {
				count++;
				total_periods += count;
			}
		}
		return total_periods < 1000000000 ? total_periods : -1;
	}
}
